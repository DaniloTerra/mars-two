Run application
```
make run
```

Test application
```
make test
```

Routes:
```
POST http://localhost:8080/rest/mars/{instruction}
```

Examples:
```
curl -i -s --request POST http://localhost:8080/rest/mars/MMRMMRMM
curl -i -s --request POST http://localhost:8080/rest/mars/MML
```

