from flask import Blueprint, abort, request, Response
from models.UserPokemon import UserPokemon
from bl.UserPokemonService import UserPokemonService
import json
from web import PokerocketAdapters

page = Blueprint('user_pokemon_page', __name__, template_folder='templates')
userPokemonService = UserPokemonService()


@page.route('/user/pokemon', methods=['POST'])
def addUserPokemon():
    jdata = request.get_json()
    userPokemon = UserPokemon(**jdata)
    id = pokemonService.addUserPokemon(userpokemon)
    return Response(json.dumps(id), status=200, content_type="application/json")


@page.route('/user/pokemon/<path:userid>', methods=['GET'])
def getAllUserPokemon(userId):
    userPokemonJson = PokerocketAdapters.as_json(userPokemonService.getAllUserPokemon())
    return Response(userPokemonJson, status=200, content_type="application/json")


@page.route('/user/pokemon/<path:id>', methods=['GET'])
def getUserPokemon(id):
    return Response(PokerocketAdapters.as_json(userPokemonService.getUserPokemon(id)), 200, content_type="application/json")

