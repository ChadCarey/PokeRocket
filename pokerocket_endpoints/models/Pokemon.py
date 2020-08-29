from sqlalchemy import Column, Integer, String
from models import Base

class Pokemon(Base):
    __tablename__ = 'pokemon'

    id = Column(Integer, primary_key=True, nullable=False)
    name = Column(String(64), nullable=False)
    lastname = Column(String(64), nullable=False)
    height = Column(Integer, nullable=False)
    sprites = Column(String(64), nullable=False)
    weight = Column(Integer, nullable=False)
    hp = Column(Integer, nullable=False)
    attack = Column(Integer, nullable=False)
    defense = Column(Integer, nullable=False)
    specialAttack = Column(Integer, nullable=False)
    specialDefense = Column(Integer, nullable=False)
    speed = Column(Integer, nullable=False)

    def __repr__(self):
        return str(self.__dict__)
