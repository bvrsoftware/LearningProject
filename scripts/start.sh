echo "Running start build .........."
config=${1?Error: Please provide config type}
profile=${2?Error: Please provide profile type}
CODE_DIRECTORY=$(pwd)
Build_Config="Dconfig.type=$config -Dspring.profiles.active=$profile"
pid=$(ps -eaf | grep JTSLearning.jar | grep -v "grep" | grep "$Build_Config " | grep -v "grep" | awk '{print $2}')
if test -z "$pid"
then
    echo "JTSLearning $Build_Config is not running"
else
    echo "JTSLearning previous Process ID: "$pid
    kill $pid
fi
nohup java -jar -Dconfig.type="$config" -Dspring.profiles.active="$profile" "$CODE_DIRECTORY"/JTSLearning.jar -Dcom.sun.management.jmxremote.port=6000 -Xms4G -Xmx4G -Xss1M -XX:ObjectAlignmentInBytes=16 -XX:+UseCompressedOops> /dev/null 2>&1 &
echo "Starting JTSLearning server................."
sleep 2s
pid=$(ps -eaf | grep JTSLearning.jar | grep -v "grep" | grep "$Build_Config " | grep -v "grep" | awk '{print $2}')
echo "JTSLearning(Config : $config, Profile : $profile) current Process ID: $pid"
echo "---------------------------------------------------------------------"

