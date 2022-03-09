package com.example.data.exceptions

import java.io.IOException

class NetworkUnavailableException(message: String = "No network available :(") :
    IOException(message)

class MovieFailed(message: String) : Exception(message)
