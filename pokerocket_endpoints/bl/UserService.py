from models import session
from models.User import User
from random import randint
from web import PokerocketAdapters as adapters

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

    def updateUser(self, updatedUserDict):
        mergedUser = None
        userId = updatedUserDict.pop('id')
        if userId is None:
            raise Exception("Cannot update User without User ID")
        try:

            fromDbUserDict = adapters.as_dict( self.getUser( userId ) )
            fromDbUserDict.update(updatedUserDict)
            print(fromDbUserDict)

            session.query(User).filter(User.id == userId).update( fromDbUserDict, synchronize_session= False )
            session.commit()

            mergedUser = self.getUser( userId )
        except Exception as e:
            session.rollback()
            raise e
        return mergedUser
