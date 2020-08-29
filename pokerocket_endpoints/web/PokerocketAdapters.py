import json

def as_dict(sqlalchemyObject):
    if sqlalchemyObject is None:
        return None

    if isinstance(sqlalchemyObject, list):
        out = []

        for x in sqlalchemyObject:
            out.append( as_dict(x) )

        return {"list": out }

    else:
        return {c.name: getattr(sqlalchemyObject, c.name) for c in sqlalchemyObject.__table__.columns}

def as_json(sqlalchemyObject):
    obDict = as_dict(sqlalchemyObject)
    return json.dumps(obDict)
