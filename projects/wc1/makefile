cs:
	@echo `pwd`
	@rsync -r -t -u -v --delete \
	--include "*.html"          \
	--include "*.txt"           \
	--exclude "*"               \
	. downing@$(CS):cs/projects/wc1/
