#!/bin/bash

# CSCI3060U - Arshdeep
# Phase6 - weekly script

# log function for verbose
function v_log() {
	if [ $VERBOSE == 1 ]
	then
		echo "$@"
	fi
}

# check for options
VERBOSE=0
while getopts "v" op
do
	case $op in
		v)
			VERBOSE=1
			v_log "entering verbose mode"
			;;
	esac
done

# initialization
USER_ACCOUNTS_FILE="useraccounts.txt"        # user accounts file name
DAILY_TRANSACTION_FILE="dailytransaction.txt" # bank accounts file name
MERGED_FILES="mergedDailyTransactions.txt" # the final merged accounts file
NEW_MASTER="newMaster.txt"

# run daily for all 5 days of the work week
for i in `seq 1 5`;
do
	v_log "running daily script"
	if [ $VERBOSE == 1 ]
	then
		./daily.sh -v
	else
		./daily.sh
	fi

	v_log "setting up files to run daily again"
	mv $MERGED_FILES $DAILY_TRANSACTION_FILE
	mv $NEW_MASTER $USER_ACCOUNTS_FILE
done
