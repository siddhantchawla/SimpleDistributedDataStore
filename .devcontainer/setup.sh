#!/bin/bash
set -e

# Define etcd version
ETCD_VERSION="v3.5.12"
ETCD_TAR="etcd-${ETCD_VERSION}-linux-amd64.tar.gz"
ETCD_DIR="etcd-${ETCD_VERSION}-linux-amd64"

# Download and install etcd
curl -L https://github.com/etcd-io/etcd/releases/latest/download/$ETCD_TAR -o $ETCD_TAR
tar xzvf $ETCD_TAR
sudo mv $ETCD_DIR/etcd $ETCD_DIR/etcdctl /usr/local/bin/
rm -rf $ETCD_TAR $ETCD_DIR

# Start etcd in the background
nohup etcd --listen-client-urls http://0.0.0.0:2379 --advertise-client-urls http://0.0.0.0:2379 > /tmp/etcd.log 2>&1 &
