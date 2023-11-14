# api_sample


http://localhost:8080/graphiql

query {
  bookById(id: 1) {
    id
    name
    pageCount
    author {
      id
      firstName
      lastName
    }
  }
}


query {
  bookAll {
    id
    name
    pageCount
    author {
      id
      firstName
      lastName
    }
  }
}

curl -H "Content-Type:application/json" -X POST http://localhost:8080/graphql -d '{ "query" : "query{bookAll { id name pageCount author{id firstName lastName}}}" }' 



