#TASコマンド　0805mushiさんコマンド
```angular2html
 1006  mkdir deploy
 1007  # Terminal all commands
 1008  brew install cloudfoundry/tap/cf-cli@8
 1009  cf --version
 1010  cf login -a https://api.sys.sandbox.aws.maki.lol/
 1011  cf space
 1012  cf space demo
 1013  cf --version
 1014  cf help
 1015  cf config
 1016  cf help
 1017  cd deploy
 1018  cd deploy
 1019  touch manifest.yaml
 1020  cf push -f deploy/manifest.yaml
 1021  cf push -f manifest.yaml
 1022  cf apps
 1023  cf logs bookmarks-mizo-masaru --recent
 1024  cf marketplace
 1025  cf create-service postgres micro-2gb bookmark-mizo-masaru-db
 1026  cf services
 1027  cf services
 1028  cf services
 1029  cf apps
 1030  cf bind-service bookmarks-mizo-masaru
 1031  cf bind-service bookmarks-mizo-masaru bookmark-mizo-masaru-db
 1032  cf s
 1033  cf service
 1034  cf services
 1035  cf restage bookmarks-mizo-masaru
 1036  cf apps
 1037  history
 1038  curl -X POST https://bookmarks-mizo-masaru.apps.sandbox.aws.maki.lol/api/v1/bookmarks -H "Content-Type: application/json" -d '{"title":"aaa","url":"bbb"}'
 1039  curl -X POST https://bookmarks-mizo-masaru.apps.sandbox.aws.maki.lol/api/v1/bookmarks -H "Content-Type: application/json" -d '{"title":"aaa","url":"bbb"}'
 1040  cf apps
 1041  cf sevices
 1042  cf services
 1043  cf apps
 1044  cf apps bookmarks-mizo-masaru
 1045  cf app bookmarks-mizo-masaru
 1046  cf scale bookmarks-mizo-masaru -m 2G
 1047  cf app bookmarks-mizo-masaru
 1048  cf scale bookmarks-mizo-masaru -i 2
 1049  cf apps
 1050  cf app bookmarks-mizo-masaru
 1051  cf scale bookmarks-mizo-masaru -i 1
 1052  cf apps
 1053  cf scale bookmarks-mizo-masaru -m 1G
 1054  cf logs bookmarks-mizo-masaru
 1055  cf logs bookmarks-mizo-masaru --recent
 1056  cf services
 1057  cf unbind-service bookmarks-mizo-masaru bookmark-mizo-masaru-db
 1058  cf delete-service bookmark-mizo-masaru-db
 1059  cf delete bookmarks-mizo-masaru
 1060  cf apps

```