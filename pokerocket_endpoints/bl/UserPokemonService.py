from models import session
from models.UserPokemon import UserPokemon
from random import randint
from web import PokerocketAdapters as adapters
from bl.PokemonService import PokemonService
from bl import SystemConstants as sysConst

class UserPokemonService():

    def __init__(self):
        self.pokemonService = PokemonService()

    def addBasePokemonToUser(self, addRequestDict):
        try:
            userId = addRequestDict.get("userId")
            pokedexId = addRequestDict.get("pokedexId")

            pokemon = self.pokemonService.getPokemonByPokedexId(pokedexId)
            if pokemon is None:
                raise Exception("Pokemon with pokedexId:" + str(pokedexId) + " was not found!")

            userPokemon = UserPokemon()
            userPokemon.userId = userId
            userPokemon.pokedexId = pokedexId
            userPokemon.name = pokemon.name
            userPokemon.nickname = addRequestDict.get("nickname", pokemon.name)
            userPokemon.height = pokemon.height
            userPokemon.sprites = pokemon.sprites
            userPokemon.weight = pokemon.weight
            userPokemon.hunger = sysConst.MAX_HUNGER
            userPokemon.maxHp = pokemon.hp
            userPokemon.currentHp = pokemon.hp
            userPokemon.attack = pokemon.attack
            userPokemon.defense = pokemon.defense
            userPokemon.specialAttack = pokemon.specialAttack
            userPokemon.specialDefense = pokemon.specialDefense
            userPokemon.speed = pokemon.speed
            userPokemon.healthState = sysConst.ALIVE_POKEMON_STATE

            session.add(userPokemon)
            session.flush()
            session.commit()
            return userPokemon.id
        except Exception as e:
            session.rollback()
            raise e


    def getUserPokemon(self, id):
        userPokemon = session.query(UserPokemon).get(id)
        return userPokemon


    def updateUserPokemon(self, updatedUserPokemonDict):
        mergedUserPokemon = None
        userPokemonId = updatedUserPokemonDict.pop('id')
        if userPokemonId is None:
            raise Exception("Cannot update UserPokemon without UserPokemon ID")
        try:

            fromDbUserPokemonDict = adapters.as_dict( self.getUserPokemon( userPokemonId ) )
            fromDbUserPokemonDict.update(updatedUserPokemonDict)
            print(fromDbUserPokemonDict)

            session.query(UserPokemon).filter(UserPokemon.id == userPokemonId).update( fromDbUserPokemonDict, synchronize_session= False )
            session.commit()

            mergedUserPokemon = self.getUserPokemon( userPokemonId )
        except Exception as e:
            session.rollback()
            raise e

        return mergedUserPokemon
