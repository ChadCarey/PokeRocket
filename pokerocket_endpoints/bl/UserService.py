from models import session
from models.User import User
from random import randint


class UserService():

    def addUser(self, newUser):
        try:
            newUser.salt = randint(0, 10000000)
            session.add(newUser)
            session.commit()
            return newUser.id
        except Exception as e:
            session.rollback()
            raise e

    def getUser(self, id):
        user = session.query(User).get(id)
        return user

    def updateUser(self, updatedUser):
        if updatedUser.id is None:
            raise Exception("Cannot update User without User ID")
        db.session.merge(updatedUser)
        db.session.flush()
        db.session.commit()
