import unittest
import requests
from random import randint


class TestUserEndpoints(unittest.TestCase):

    SERVER = "http://localhost:5000"
    ADD_USER_URL = SERVER + "/user"
    GET_ALL_USER = SERVER + "/user"
    GET_USER_URL = SERVER + "/user/{id}"
    
   

    def test_addUser(self):
        newUserDict = {
            "firstname" : "TestiTrainer",
            "lastname" : "LastTrainer",
            "username" : "UserTrainer",
            "password" : "1234",
            "role" : 0
        }
        res = requests.post(self.ADD_USER_URL, json=newUserDict)
        self.assertEqual(res.status_code, 200)
        self.assertEqual(res.headers['Content-Type'], "application/json")

        jdata = res.json()
        self.assertIsNotNone(jdata, jdata)

    def test_getUser(self):
        newUserDict = {
            "firstname" : "TestiTrainer",
            "lastname" : "LastTrainer",
            "username" : "UserTrainer",
            "password" : "1234",
            "role" : 0
        }
        res = requests.post(self.ADD_USER_URL, json=newUserDict)
        self.assertEqual(res.status_code, 200)
        userID= res.json()
        url = self.GET_USER_URL.format(id=userID)
        res = requests.get(url)

        self.assertEqual(res.status_code, 200)
        self.assertEqual(res.headers['Content-Type'], "application/json")

        jdata = res.json()
        self.assertIsNotNone(jdata, jdata)

        self.assertEqual(jdata.get('id', None), userID)

if __name__ == "__main__":
    unittest.main()
