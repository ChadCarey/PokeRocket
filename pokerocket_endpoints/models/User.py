from sqlalchemy import Column, Integer, String
from models import Base

class User(Base):
    __tablename__ = 'pokemon'

    id = Column(Integer, primary_key=True, nullable=False)
    firstname = Column(String(64), nullable=False)
    lastname = Column(String(64), nullable=False)
    username = Column(String(64), nullable=False)
    salt = Column(Integer, nullable=False)
    password = Column(String(64), nullable=False)
    role = Column(Integer, nullable=False)

    def __repr__(self):
        return str(self.__dict__)
