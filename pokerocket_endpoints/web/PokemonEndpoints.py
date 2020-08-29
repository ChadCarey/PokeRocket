from flask import Blueprint, abort, request, Response
from models.Pokemon import Pokemon
from bl.PokemonService import PokemonService
import json
from web import PokerocketAdapters

page = Blueprint('page', __name__, template_folder='templates')
pokemonService = PokemonService()



@page.route('/pokemon', methods=['POST'])
def addPokemon():
    jdata = request.get_json()
    poke = Pokemon(**jdata)
    id = pokemonService.addPokemon(poke)
    return Response(json.dumps({"id": id}), status=200)


@page.route('/pokemon', methods=['GET'])
def getAllPokemon():
    pokeJson = PokerocketAdapters.as_json(pokemonService.getAllPokemon())
    return Response(pokeJson, status=200, content_type="application/json")


@page.route('/pokemon/<path:id>', methods=['GET'])
def getPokemon(id):
    return Response(PokerocketAdapters.as_json(pokemonService.getPokemon(id)), 200, content_type="application/json")


@page.route('/pokedex/<path:id>', methods=['GET'])
def getPokemonByPokedexId(id):
    return Response(PokerocketAdapters.as_json(pokemonService.getPokemonByPokedexId(id)), 200, content_type="application/json")
