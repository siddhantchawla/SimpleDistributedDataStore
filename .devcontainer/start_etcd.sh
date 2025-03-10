# Create the start_etcd.sh script
echo '#!/bin/bash
etcd --listen-client-urls http://127.0.0.1:2379 --advertise-client-urls http://127.0.0.1:2379' > .devcontainer/start_etcd.sh
