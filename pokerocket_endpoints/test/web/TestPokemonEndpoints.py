import unittest
import requests
from random import randint


class TestPokemonEndpoints(unittest.TestCase):

    SERVER = "http://localhost:5000"
    ADD_POKEMON_URL = SERVER + "/pokemon"
    GET_ALL_POKEMON = SERVER + "/pokemon"
    GET_POKEMON_URL = SERVER + "/pokemon/{id}"
    GET_POKEMON_BY_POKEDEX_URL = SERVER + "/pokedex/{id}"
    NULLIMON_DB_ID = 1
    NULLIMON_POKEDEX_ID = 0


    def test_addPokemon(self):
        newPokeDict = {
            "pokedexId":randint(1,999999),
            "name": "Testimon",
            "height": 0,
            "sprites": "",
            "weight": 0,
            "hp": 0,
            "attack": 0,
            "defense": 0,
            "specialAttack": 0,
            "specialDefense": 0,
            "speed": 0
        }
        res = requests.post(self.ADD_POKEMON_URL, json=newPokeDict)
        self.assertEqual(res.status_code, 200)
        self.assertEqual(res.headers['Content-Type'], "application/json")

        jdata = res.json()
        self.assertIsNotNone(jdata, jdata)


    def test_addPokemonShouldNotAddMultiplePokemonWithSamePokedexId(self):
        newPokeDict = {
            "pokedexId":randint(1,999999),
            "name": "Testimon",
            "height": 0,
            "sprites": "",
            "weight": 0,
            "hp": 0,
            "attack": 0,
            "defense": 0,
            "specialAttack": 0,
            "specialDefense": 0,
            "speed": 0
        }
        res = requests.post(self.ADD_POKEMON_URL, json=newPokeDict)
        self.assertEqual(res.status_code, 200)
        self.assertEqual(res.headers['Content-Type'], "application/json")
        res = requests.post(self.ADD_POKEMON_URL, json=newPokeDict)
        self.assertEqual(res.status_code, 500)
        self.assertEqual(res.headers['Content-Type'], "application/json")


    def test_getAllPokemon(self):
        res = requests.get(self.GET_ALL_POKEMON)
        self.assertEqual(res.status_code, 200)
        self.assertEqual(res.headers['Content-Type'], "application/json")

        jdata = res.json()
        self.assertIsNotNone(jdata, jdata)
        self.assertTrue(isinstance(jdata, list))


    def test_getPokemon(self):
        url = self.GET_POKEMON_URL.format(id=self.NULLIMON_DB_ID)
        res = requests.get(url)

        self.assertEqual(res.status_code, 200)
        self.assertEqual(res.headers['Content-Type'], "application/json")

        jdata = res.json()
        self.assertIsNotNone(jdata, jdata)

        self.assertEqual(jdata.get('id', None), self.NULLIMON_DB_ID)


    def test_getPokemonByPokedexId(self):
        url = self.GET_POKEMON_BY_POKEDEX_URL.format(id=self.NULLIMON_POKEDEX_ID)
        res = requests.get(url)

        self.assertEqual(res.status_code, 200)
        self.assertEqual(res.headers['Content-Type'], "application/json")

        jdata = res.json()
        print(jdata)
        self.assertIsNotNone(jdata, jdata)

        self.assertEqual(jdata.get('pokedexId', None), self.NULLIMON_POKEDEX_ID)



if __name__ == "__main__":
    unittest.main()
