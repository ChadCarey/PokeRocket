from flask import Flask
from web import PokemonEndpoints

app = Flask(__name__)


app.register_blueprint(PokemonEndpoints.page)


if __name__ == "__main__":
    app.run()
