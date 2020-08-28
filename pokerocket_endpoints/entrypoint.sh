pip3 install -r /mnt/host/pokerocket_endpoints/requirements.txt

touch lockfile
tail -F lockfile

flask run --host=0.0.0.0
