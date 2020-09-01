from sqlalchemy import Column, Integer, String, UniqueConstraint, ForeignKey
from models import Base

class UserPokemon(Base):
    __tablename__ = 'user_pokemon'

    id = Column(Integer, primary_key=True, nullable=False)
    userId = Column(Integer, ForeignKey('user.id'), nullable=False)
    pokedexId = Column(Integer, nullable=False, unique=True)
    name = Column(String(64), nullable=False)
    nickname =Column(String(64), nullable=False)
    height = Column(Integer, nullable=False)
    sprites = Column(String(64), nullable=False)
    weight = Column(Integer, nullable=False)
    hunger = Column(Integer, nullable=False)
    maxHp = Column(Integer, nullable=False)
    currentHp = Column(Integer, nullable=False)
    attack = Column(Integer, nullable=False)
    defense = Column(Integer, nullable=False)
    specialAttack = Column(Integer, nullable=False)
    specialDefense = Column(Integer, nullable=False)
    speed = Column(Integer, nullable=False)
    healthState = Column(String(64), nullable=False)

    # TODO: add last updated

    def __repr__(self):
        return str(self.__dict__)
