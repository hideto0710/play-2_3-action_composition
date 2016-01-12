ActionBuilder Sample
===

## Run
```
./activator run
```

## Request

### async
```
curl http://localhost:9000/id/1
```

### sync
```
curl http://localhost:9000/id_str/1
```

## Log
```
[info] application - Start action
[info] application - End action
Duration: 108, Result: Result(200, Map(Content-Type -> application/json; charset=utf-8))
```