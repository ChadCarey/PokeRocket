from models import session
from models.Pokemon import Pokemon


class PokemonService():

    def addPokemon(self, newPoke):
        try:
            session.add(newPoke)
            session.commit()
            return newPoke.id
        except Exception as e:
            session.rollback()
            raise e


    def getAllPokemon(self):
        pokes = session.query(Pokemon).all()
        return pokes


    def getPokemon(self, id):
        poke = session.query(Pokemon).get(id)
        return poke


    def getPokemonByPokedexId(self, id):
        poke = session.query(Pokemon).filter_by(pokedexId=id)
        return poke
