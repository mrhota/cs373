cs:
	@echo `pwd`
	@rsync -r -t -u -v --delete \
	--include "*.html"          \
	--include "*.py"            \
	--exclude "*"               \
	. downing@$(CS):cs/projects/amort/
