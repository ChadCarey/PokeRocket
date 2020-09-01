import unittest
import requests
from random import randint


class TestUserPokemonEndpoints(unittest.TestCase):

    SERVER = "http://localhost:5000"
    ADD_USER_POKEMON_URL = SERVER + "/user/pokemon/add"
    UPDATE_USER_POKEMON_URL = SERVER + "/user/pokemon"
    GET_ALL_USER_POKEMON = SERVER + "/user/pokemon"
    GET_USER_POKEMON_URL = SERVER + "/user/pokemon/{id}"



    def test_addBasePokemonToUser(self):
        newUserPokemonDict = {
            "pokedexId": 4,
            "userId": 4,
            "nickname": "SpicyJoe"
        }
        res = requests.post(self.ADD_USER_POKEMON_URL, json=newUserPokemonDict)
        self.assertEqual(res.status_code, 200)
        self.assertEqual(res.headers['Content-Type'], "application/json")

        jdata = res.json()
        self.assertIsNotNone(jdata, jdata)


    # def test_getUserPokemon(self):
    #     newUserPokemonDict = {
    #         "firstname" : "TestiTrainer",
    #         "lastname" : "LastTrainer",
    #         "userPokemonname" : "UserPokemonTrainer",
    #         "password" : "1234",
    #         "role" : 0
    #     }
    #     res = requests.post(self.ADD_USER_POKEMON_URL, json=newUserPokemonDict)
    #     self.assertEqual(res.status_code, 200)
    #     userPokemonId= res.json()

    #     url = self.GET_USER_POKEMON_URL.format(id=userPokemonId)
    #     res = requests.get(url)

    #     self.assertEqual(res.status_code, 200)
    #     self.assertEqual(res.headers['Content-Type'], "application/json")

    #     jdata = res.json()
    #     self.assertIsNotNone(jdata, jdata)

    #     self.assertEqual(jdata.get('id', None), userPokemonId)


    # def test_updateUserPokemon(self):
    #     PRIOR_ROLE = 0
    #     EXPECTED_ROLE = 1
    #     newUserPokemonDict = {
    #         "firstname" : "TestiTrainer",
    #         "lastname" : "LastTrainer",
    #         "userPokemonname" : "UserPokemonTrainer",
    #         "password" : "1234",
    #         "role" : PRIOR_ROLE
    #     }
    #     res = requests.post(self.ADD_USER_POKEMON_URL, json=newUserPokemonDict)
    #     self.assertEqual(res.status_code, 200)
    #     self.assertEqual(res.headers['Content-Type'], "application/json")

    #     jdata = res.json()
    #     self.assertIsNotNone(jdata, jdata)
    #     self.assertTrue(isinstance(jdata, int))

    #     # updated recently added userPokemon
    #     newUserPokemonDict['id'] = jdata
    #     newUserPokemonDict['role'] = EXPECTED_ROLE
    #     res = requests.put(self.ADD_USER_POKEMON_URL, json=newUserPokemonDict)
    #     self.assertEqual(res.status_code, 200)
    #     self.assertEqual(res.headers['Content-Type'], "application/json")

    #     updatedUserPokemon = res.json()
    #     self.assertIsNotNone(updatedUserPokemon, updatedUserPokemon)
    #     self.assertTrue(isinstance(updatedUserPokemon, dict))

    #     self.assertEqual(updatedUserPokemon.get('role', None), EXPECTED_ROLE)


if __name__ == "__main__":
    unittest.main()
