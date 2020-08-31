from flask import Blueprint, abort, request, Response
from models.User import User
from bl.UserService import UserService
import json
from web import PokerocketAdapters

page = Blueprint('user_page', __name__, template_folder='templates')
userService = UserService()

@page.route('/user', methods=['POST'])
def addUser():
    jdata = request.get_json()
    user = User(**jdata)
    id = UserService.addUser(user)
    return Response(json.dumps({"id": id}), status=200)


@page.route('/user/<path:id>', methods=['GET'])
def getUser(id):
    return PokerocketAdapters.as_json(userService.getUser(id))