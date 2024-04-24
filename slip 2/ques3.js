const userData = {
  username: "john_doe",
  password: "password123",
};

function loginUser(username, password) {
  return new Promise((resolve, reject) => {
    if (username === userData.username && password === userData.password) {
      resolve("Login successfully");
    } else {
      reject(new Error("Login failed"));
    }
  });
}

loginUser("john_doe", "password123")
  .then((message) => {
    console.log(message);
  })
  .catch((error) => {
    console.error(error.message);
  });
