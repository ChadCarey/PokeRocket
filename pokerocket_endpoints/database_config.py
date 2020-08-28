import os
from sqlalchemy import create_engine
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy.orm import sessionmaker
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
SessionFactory = sessionmaker(bind=engine)
SessionFactory.configure(bind=engine)

session = SessionFactory()
Base = declarative_base()
