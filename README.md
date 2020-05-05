# cross-platform-installer

The project is aimed to pack executable jar file with external (non-bundled) resources into a cross-platfrom installer (based on [jpackage](https://openjdk.java.net/jeps/343) - a Packaging Tool from JDK 14)

The installer for desired platform (MacOS, Windows, Linux) could be build only on target platform only.

## Prerequisites
Native packages will be generated using tools on the target platform. You should install additional software before creating an installer
- for Windows: 
    - [Wix](https://wixtoolset.org), a third-party tool, is required to generate msi or exe packages
- for Linux:
    - fakeroot and beanutils, rpm. They could be installed (on Debian, Ubuntu) simply 
    ```
    apt-get -y install fakeroot
    apt-get -y install binutils
    apt-get -y install rpm
   ```  

## To package an installer:
- place jar file with any amount of files into **assets** directory
- modify file `jpackage.properties` in order to reflect your data in application - name, main jar, main class etc. 
- run `mvn package`
- the installer is created `target/dist/${app.name}-{app.version}.{ext}`, 
  where `{ext}` is the installer's file extension. It is platform-dependent
    - for MacOS - `.pkg` and `.dmg`
    - for Windows - `.exe` and `.msi`
    - for Linux - `.deb` and `.rpm`
   

## Screenshot 
### MacOS Screenshots
* Generated installers - `.pkg` and `.dmg` in `target/dist` directory
![mac screenshot1](./docs/macos/shot1.png)
* DMG installer in action
![mac screenshot2](./docs/macos/shot2.png)
![mac screenshot3](./docs/macos/shot3.png)
* PKG installer in action
![mac screenshot4](./docs/macos/shot4.png)
![mac screenshot5](./docs/macos/shot5.png)
![mac screenshot6](./docs/macos/shot6.png)
![mac screenshot7](./docs/macos/shot7.png)
![mac screenshot8](./docs/macos/shot8.png)
* Inside /Applications/MyGreatApp.app/
![mac screenshot9](./docs/macos/shot9.png)

### Windows Screenshots
* Generated installers - `.exe` and `.msi` in `target/dist` directory
![win screenshot1](./docs/windows/shot1.png)
* Installer in action
![win screenshot2](./docs/windows/shot2.png)
![win screenshot3](./docs/windows/shot3.png)
![win screenshot4](./docs/windows/shot4.png)
![win screenshot5](./docs/windows/shot5.png)
![win screenshot6](./docs/windows/shot6.png)
* Inside C:\Program Files\MyGreatApp\
![win screenshot7](./docs/windows/shot7.png)
* Uninstaller in action
![win screenshot8](./docs/windows/shot8.png)
![win screenshot9](./docs/windows/shot9.png)

### Linux Screenshots
* Generated installers - `.deb` and `.pkg` in `target/dist` directory
![lin screenshot1](./docs/linux/shot1.png)
* DEB Installer in action
![lin screenshot2](./docs/linux/shot2.png)
![lin screenshot3](./docs/linux/shot3.png)
![lin screenshot4](./docs/linux/shot4.png)
![lin screenshot5](./docs/linux/shot5.png)
* Inside /opt/mygreatapp/
![lin screenshot6](./docs/linux/shot6.png)
* Uninstaller in action
![lin screenshot7](./docs/linux/shot7.png)
