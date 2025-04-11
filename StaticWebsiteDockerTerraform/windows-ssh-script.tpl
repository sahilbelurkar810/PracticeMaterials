add-content -path c:/users/anants/.ssh/config -value @'

Host ${hostname}
    Hostname ${hostname}
    User ${user}
    IdentityFile ${identityfile}
'@