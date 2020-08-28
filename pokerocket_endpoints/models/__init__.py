from database_config import Base, engine
from os.path import dirname, basename, isfile, join
import glob
import importlib

modules = glob.glob(join(dirname(__file__), "*.py"))
__all__ = [ basename(f)[:-3] for f in modules if isfile(f) and not f.endswith('__init__.py')]

print(__path__)
print(__all__)

for module in __all__:
    # fullPath = "/".join([__path__, module])
    # print(fullPath)
    importlib.import_module("models."+module)

Base.metadata.create_all(engine)
