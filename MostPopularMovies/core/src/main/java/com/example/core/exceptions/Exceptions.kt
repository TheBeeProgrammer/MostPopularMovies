package com.example.core.exceptions

import java.io.IOException

class NetworkUnavailableException(message: String = "No network available :(") :
    IOException(message)
