from flask import Flask
from web import PokemonEndpoints
from web import UserEndpoints
import werkzeug
from werkzeug.exceptions import HTTPException, BadRequest, InternalServerError
import json

app = Flask(__name__)

app.register_blueprint(PokemonEndpoints.page)
app.register_blueprint(UserEndpoints.page)



if __name__ == "__main__":
    app.run()
