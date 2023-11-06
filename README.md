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