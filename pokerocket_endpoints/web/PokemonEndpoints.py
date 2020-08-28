from flask import Blueprint, abort
from database_config import db

from models import Pokemon

page = Blueprint('page', __name__, template_folder='templates')

@page.route('/pokemon')
def getAllPokemon():
    pass
