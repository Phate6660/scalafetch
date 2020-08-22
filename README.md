## scalafetch

Learning Scala, by implementing a neofetch alternative.

Currently supported: distro and kernel.

## help

`sbt:scalafetch> run -H`

```
-d  display the distro
-e  display $EDITOR
-H  display this help
-h  display hostname
-k  display the kernel
-s  display the shell
-u  display the user
```

## Current output (from my machine)

`sbt:scalafetch> run -d true -e true -h true -k true -s true -u true`

```
Distro:    Gentoo
Editor:    /usr/bin/emacsclient
Hostname:  gentoo
Kernel:    5.4.48-ck-valley
Shell:     /bin/bash
User:      valley
```
