wget https://github.com/etcd-io/etcd/releases/download/v3.5.12/etcd-v3.5.12-linux-amd64.tar.gz -O etcd.tar.gz

tar xzvf etcd.tar.gz
sudo mv etcd-v3.5.12-linux-amd64/etcd etcd-v3.5.12-linux-amd64/etcdctl /usr/local/bin/

etcd --listen-client-urls http://0.0.0.0:2379 --advertise-client-urls http://0.0.0.0:2379
