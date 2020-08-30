from models import session
from models.User import User


class UserService():

    def addUser(self, newUser):
        try:
            session.add(newUser)
            session.commit()
            return newUser.id
        except Exception as e:
            session.rollback()
            raise e

    def getUser(self, id):
        user = session.query(User).get(id)
        return user
