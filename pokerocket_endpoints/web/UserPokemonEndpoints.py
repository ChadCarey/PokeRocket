from flask import Blueprint, abort, request, Response
from models.UserPokemon import UserPokemon
from bl.UserPokemonService import UserPokemonService
import json
from web import PokerocketAdapters

page = Blueprint('user_pokemon_page', __name__, template_folder='templates')
userPokemonService = UserPokemonService()

@page.route('/user/pokemon/add', methods=['POST'])
def addBasePokemonToUser():
    addRequestDict = request.get_json()
    id = userPokemonService.addBasePokemonToUser(addRequestDict)
    return Response(json.dumps(id), status=200, content_type="application/json")


@page.route('/user/pokemon/<path:id>', methods=['GET'])
def getUserPokemon(id):
    jUserPokemon = PokerocketAdapters.as_json(userPokemonService.getUserPokemon(id))
    return Response(jUserPokemon, status=200, content_type="application/json")


@page.route('/user/pokemon/update', methods=['PUT'])
def updateUserPokemon():
    updateDict = request.get_json()
    updatedUserPokemon = userPokemonService.updateUserPokemon(updateDict)
    jUserPokemon = PokerocketAdapters.as_json(updatedUserPokemon)
    return Response(jUserPokemon, status=200, content_type="application/json")
