import unittest
import requests
from random import randint


class TestUserEndpoints(unittest.TestCase):

    SERVER = "http://localhost:5000"
    ADD_USER_URL = SERVER + "/user"
    UPDATE_USER_URL = SERVER + "/user"
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
        userId= res.json()

        url = self.GET_USER_URL.format(id=userId)
        res = requests.get(url)

        self.assertEqual(res.status_code, 200)
        self.assertEqual(res.headers['Content-Type'], "application/json")

        jdata = res.json()
        self.assertIsNotNone(jdata, jdata)

        self.assertEqual(jdata.get('id', None), userId)


    def test_updateUser(self):
        PRIOR_ROLE = 0
        EXPECTED_ROLE = 1
        newUserDict = {
            "firstname" : "TestiTrainer",
            "lastname" : "LastTrainer",
            "username" : "UserTrainer",
            "password" : "1234",
            "role" : PRIOR_ROLE
        }
        res = requests.post(self.ADD_USER_URL, json=newUserDict)
        self.assertEqual(res.status_code, 200)
        self.assertEqual(res.headers['Content-Type'], "application/json")

        jdata = res.json()
        self.assertIsNotNone(jdata, jdata)
        self.assertTrue(isinstance(jdata, int))

        # updated recently added user
        newUserDict['id'] = jdata
        newUserDict['role'] = EXPECTED_ROLE
        res = requests.put(self.ADD_USER_URL, json=newUserDict)
        self.assertEqual(res.status_code, 200)
        self.assertEqual(res.headers['Content-Type'], "application/json")

        updatedUser = res.json()
        self.assertIsNotNone(updatedUser, updatedUser)
        self.assertTrue(isinstance(updatedUser, dict))

        self.assertEqual(updatedUser.get('role', None), EXPECTED_ROLE)


if __name__ == "__main__":
    unittest.main()
