tab=()
occ=0
for i in $@; do
  gradle run --args="'"$i"'"
  done
#./script.sh ['mystere1.txt','mystere2.txt','mystere3.txt']
#$@= ['mystere1.txt','mystere2.txt','mystere3.txt']