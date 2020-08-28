import os
from sqlalchemy import create_engine, Table, Column, Integer, String, MetaData


username = os.environ['MYSQL_USER']
password = os.environ['MYSQL_PASSWORD']
host = "pokerocket_db"
port = 3306

dburl = "mysql+pymysql://{username}:{password}@{host}/pokerocketdb?host={host}?port={port}".format(
    username=username,
    password=password,
    host=host,
    port=port
)
engine = create_engine(dburl, echo = True)
db = engine.connect()


# TODO: move table definitions to ideal location for db migrations

meta = MetaData()


pokemon = Table(
   'pokemon', meta,
    Column('id', Integer, primary_key=True, nullable=False),
    Column('name', String(64), nullable=False),
    Column('lastname', String(64), nullable=False),
    Column('height', Integer, nullable=False),
    Column('sprites', String(64), nullable=False),
    Column('weight', Integer, nullable=False),
    Column('hp', Integer, nullable=False),
    Column('attack', Integer, nullable=False),
    Column('defense', Integer, nullable=False),
    Column('specialAttack', Integer, nullable=False),
    Column('specialDefense', Integer, nullable=False),
    Column('speed', Integer, nullable=False)
)


meta.create_all(engine)
