from flask import Blueprint, abort, request
from database_config import db,session

from models.Pokemon import Pokemon

page = Blueprint('page', __name__, template_folder='templates')

@page.route('/pokemon', methods=['POST'])
def addPokemon():
    try:
        jdata = request.get_json()
        poke = Pokemon(**jdata)
        session.add(poke)
        session.commit()
    except Exception as e:
        print( str(e) )
        session.rollback()
    return {"status":200}
