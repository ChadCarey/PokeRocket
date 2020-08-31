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
    id = userService.addUser(user)
    return Response(json.dumps(id), status=200, content_type="application/json")


@page.route('/user/<path:id>', methods=['GET'])
def getUser(id):
    jUser = PokerocketAdapters.as_json(userService.getUser(id))
    return Response(jUser, status=200, content_type="application/json")


@page.route('/user', methods=['PUT'])
def updateUser():
    jdata = request.get_json()
    user = User(**jdata)
    id = userService.updateUser(user)
    return Response(id, status=200, content_type="application/json")