#!/bin/bash


. /etc/profile

WORK_DIR="/opt/jcohy"
SERVICE_DIR="$WORK_DIR/blog"
SERVICE_TMP="$WORK_DIR/blogtemp"
RUN_PID="$SERVICE_DIR/bin/run.pid"

if [ ! -d $WORK_DIR ]; then
    mkdir -p $WORK_DIR
fi

if [ -f $RUN_PID ]; then
    PID=`cat $RUN_PID`
    echo "Killing former running progress $PID"
    cat $RUN_PID | xargs kill -9
    echo "Killing former running progress `cat $RUN_PID` done."
fi

yes | rm -r $SERVICE_DIR

cd $WORK_DIR
mkdir -p $SERVICE_DIR

wget $1

url=$1

unzip ${url##*/} -d $SERVICE_TMP
yes | rm ${url##*/}

mv $SERVICE_TMP/*/* $SERVICE_DIR

yes | rm -r $SERVICE_TMP


cd $SERVICE_DIR/bin/
$SERVICE_DIR/bin/flyway migrate > $SERVICE_DIR/bin/flyway.log
nohup $SERVICE_DIR/bin/blog > /dev/null 2>&1 &

echo $! > $RUN_PID
echo "SERVICE started with pid `cat $RUN_PID`"
