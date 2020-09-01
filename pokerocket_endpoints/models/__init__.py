from os.path import dirname, basename, isfile, join
import glob
import importlib
import os
from sqlalchemy import create_engine
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy.orm import sessionmaker

username = os.environ['MYSQL_USER']
password = os.environ['MYSQL_PASSWORD']
host = os.environ["MYSQL_HOST"]
port = os.environ["MYSQL_PORT"]
database = os.environ['MYSQL_DATABASE']
print("username", username)
print("password", password)
print("host", host)
print("port", port)
print("database", database)

dburl = "mysql+pymysql://{username}:{password}@{host}/{database}?host={host}?port={port}".format(
    username=username,
    password=password,
    host=host,
    port=port,
    database = database
)
engine = create_engine(dburl, echo = True)
db = engine.connect()
SessionFactory = sessionmaker(bind=engine)
SessionFactory.configure(bind=engine)

session = SessionFactory()

Base = declarative_base()

# load all models to create missing tables
modules = glob.glob(join(dirname(__file__), "*.py"))
__all__ = [ basename(f)[:-3] for f in modules if isfile(f) and not f.endswith('__init__.py')]

for module in __all__:
    # fullPath = "/".join([__path__, module])
    # print(fullPath)
    importlib.import_module("models."+module)

Base.metadata.create_all(engine)
