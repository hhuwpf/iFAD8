**FAD8&iFAD8: Two algorithms for nondispersive drainage direction simulation based on grid digital elevation models**
--------------------------------------------------------------------------
Last edit: Aug. 22, 2020 

**1. Distribution and Copyright**

Copyright (c) 2020 Pengfei Wu, Jintao Liu, Xiaole Han, Zhongmin Liang, Yangyang Liu and Junyuan Fei

This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or any later version.

This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details. You should have received a copy of the GNU General Public License along with this program. If not, see <https://www.gnu.org/licenses/>.

If you wish to use or incorporate this program (or parts of it) into other software that does not meet the GNU General Public License conditions contact the author to request permission.

Pengfei Wu

College of Hydrology and Water Resources, Hohai University

1st Xikang Rd., Nanjing 210098, Jiangsu Province, People's Republic of China

Work phone: +86 18351936707

E-mail: wpf@hhu.edu.cn

Jintao Liu

College of Hydrology and Water Resources, Hohai University

1st Xikang Rd., Nanjing 210098, Jiangsu Province, People's Republic of China

Work phone: +86 13327836738

E-mail: jtliu@hhu.edu.cn

--------------------------------------------------------------------------
**2. The Algorithms**

The FAD8 and iFAD8 algorithms are described in Wu et al. (2020). The .pdf file of 
this paper (file 2019WR026507.pdf) and the Java codes that implement the 
algorithms are provided. The original paper should be cited appropriately whenever FAD8 or iFAD8 is used.

Citation: Wu, P., Liu, J., Han, X., Liang, Z., Liu, Y., & Fei, J. (2020). Nondispersive drainage direction simulation based on flexible triangular facets. Water Resources Research, 55, e2019WR026507. https://doi.org/10.1029/2019WR026507

--------------------------------------------------------------------------
**3. File Description**

You may find three main files and two main folders in this project.
1. README.md: FAD8 and iFAD8 manual.
2. Himmelblau.txt: an ASCII DEM file for example discretized from the Himmelblau terrain proposed by Orlandini et al. [2014] (1 m resolution; 501×501 cells)
3. LICENSE: A copy of the full GNU General Public License.
4. codes folder: include a folder called FAD8&iFAD8, which is a project of Eclipse code editor, and containing the codes.
5. executable_version folder: include FAD8 and iFAD8 executable file complied for Windows.

Reference: 
Orlandini, S., G. Moretti, and A. Gavioli (2014). Analytical basis for determining slope lines in grid digital elevation models. Water Resour. Res., 50(1), 526–539, doi:10.1002/2013WR014606.

--------------------------------------------------------------------------
**4. Running FAD8 and iFAD8**

Here we only provide the executable file complied for Windows. Please keep the files and folders in the folder called executable_version intact. You can run FAD8 or iFAD8 using the FAD8.exe or iFAD8.exe in executable_version folder, respectively. After setting the path of DEM file and the path to save the drainage direction file, the algorithm will be executed.

Here an example is provided.

Firstly, run the executable file such as iFAD8.

![](https://github.com/hhuwpf/iFAD8/blob/master/img/clip_image002.jpg)

Secondly, choose the DEM file.

![](https://github.com/hhuwpf/iFAD8/blob/master/img/clip_image004.jpg)
Finally, choose the location to save the drainage directions and name the direction file. Here we set the name as “dir”, and a suffix of “.txt” will be added automatically.

![](https://github.com/hhuwpf/iFAD8/blob/master/img/clip_image006.jpg) ![](https://github.com/hhuwpf/iFAD8/blob/master/img/clip_image007.png)

When the calculation is finished, a message dialog will appear.

![](https://github.com/hhuwpf/iFAD8/blob/master/img/clip_image008.png)


--------------------------------------------------------------------------
**5. The Java Codes**

The Java classes can be found in “iFAD8\codes\FAD8&iFAD8\src\algorithm\”. Moreover, you can import the FAD8&iFAD8 folder in “iFAD8\codes\” to Eclipse code editor directly as an existing project. Detailed remarks are in the classes.

--------------------------------------------------------------------------
**6. Things to Keep in Mind**

1.The import DEM should be in the ASCII TXT format.

2.Codes for depression removal based on an old theory of Martz & Garbrcht. [1992] but using a new flooding technique have been contained, so a real-world DEM with depressions and flats can be imported directly, and a gradient of 0.001 m will be added to the flat DEM cells.

3.The outcome drainage directions are in the Esri format, which can be imported into ArcGIS using the function called ASCII to Raster.

4.The application of the executable_version to any DEM with massive cells may be limited because it may be out of the memory set initially. To deal with these DEMs, you may just run the codes but not the executable_version, and the Default VM Arguments should be set, for example, “-Xms 31200m –Xmx 51200m”.

5.The input/output process of Java is inherently inefficient , so users should be prepared for this. Only the codes but not the executable_version can display the running time for each step.

6.A Java structure called PriorityQueue is used to sort the cells with elevations from high to low. Limited by the maximum length of PriorityQueue, the DEM cannot contains too much cells. We do not yet know what the upper limit will be, but we successfully used the codes to calculate drainage directions for a DEM with more than 500,000,000 cells.

Reference: 
MARTZ & GARBRCHT (1992).NUMERICAL DEFINITION OF DRAINAGE NETWORK AND SUBCATCHMENT AREAS FROM DIGITAL ELEVATION MODELS. Computers & Geosciences, 18(6):747-761.