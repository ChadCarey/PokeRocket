touch lockfile
tail -F lockfile

pip3 install -r /mnt/host/pokerocket_endpoints/requirements.txt
flask run --host=0.0.0.0
