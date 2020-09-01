from flask import Flask
from web import PokemonEndpoints
from web import UserEndpoints
from web import UserPokemonEndpoints
import werkzeug
from werkzeug.exceptions import HTTPException, BadRequest, InternalServerError
import json

app = Flask(__name__)

app.register_blueprint(PokemonEndpoints.page)
app.register_blueprint(UserEndpoints.page)
app.register_blueprint(UserPokemonEndpoints.page)



@app.errorhandler(HTTPException)
def handle_exception(e):
    """Return JSON instead of HTML for HTTP errors."""
    # start with the correct headers and status code from the error
    response = e.get_response()
    # replace the body with JSON
    response.data = json.dumps({
        "code": e.code,
        "name": e.name,
        "description": e.description,
    })
    response.content_type = "application/json"
    return response


if __name__ == "__main__":
    app.run()
