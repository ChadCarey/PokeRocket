from flask import Blueprint, abort
from database_config import db

page = Blueprint('page', __name__, template_folder='templates')

@page.route('/Pokemon')
def hello():
    db.execute("show tables")
