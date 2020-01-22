import java.util.ArrayList;
public class BSTrun
{
static ArrayList<Integer> num = new ArrayList<Integer>();
static BinarySearchTree<Dam> temp = new BinarySearchTree<Dam>();
public static void main(String[] args)
{
DamArrayApp DA = new DamArrayApp();
Dam[] arr = DA.makearray();
for(int a = 0;a<211;a++)
{
temp.insert(arr[a]);
//temp.preOrder();
printdams("Ngotwane Dam");


//System.out.println(temp.returnCount());
printdams("Hartbeespoort Dam");

printdams("Bon Accord Dam");

printdams("Olifantsnek Dam");

printdams("Rietvlei Dam");

printdams("Buffelspoort Dam");

printdams("Bospoort Dam");

printdams("Lindleyspoort Dam");

printdams("Warmbad Dam");

printdams("Roodeplaat Dam");

printdams("Kosterrivier Dam");

printdams("Klipvoor Dam");

printdams("Swartruggens Dam");
printdams("Vaalkop Dam");
printdams("Roodekopjes Dam");
printdams("Marico-Bosveld Dam");
printdams("Klein Maricopoort Da");
printdams("Kromellenboog Dam");
printdams("Molatedi Dam");
printdams("Sehujwane Dam");
printdams("Madikwe Dam");
printdams("Pella Dam");
printdams("Mokolo Dam");
printdams("Doorndraai Dam");
printdams("Glen Alpine Dam");
printdams("Nzhelele Dam");
printdams("Luphephe Dam");
printdams("Nwanedzi Dam");
printdams("Mutshedzi Dam");
printdams("Albasini Dam");
printdams("Vondo Dam");
printdams("Nandoni Dam");
printdams("Witbank Dam");
printdams("Middelburg Dam");
printdams("Bronkhorstspruit Dam");
printdams("Rust Der Winter Dam");
printdams("Loskop Dam");
printdams("Rhenosterkop Dam");
printdams("Tonteldoos Dam");
printdams("Vlugkraal Dam");
printdams("Buffelskloof Dam");
printdams("De Hoop Dam");
printdams("Flag Boshielo Dam");
printdams("Ohrigstad Dam");
printdams("Blyderivierpoort Dam");
printdams("Klaserie Dam");
printdams("Tours Dam");
printdams("Ebenezer Dam");
printdams("Hans Merensky Dam");
printdams("Magoebaskloof Dam");
printdams("Vergelegen Dam");
printdams("Tzaneen Dam");
printdams("Dap Naude Dam");
printdams("Middel-Letaba Dam");
printdams("Nsami Dam");
printdams("Vaal Dam");
printdams("Grootdraai Dam");
printdams("Boskop Dam");
printdams("Johan Neser Dam");
printdams("Klerkskraal Dam");
printdams("Potchefstroom Dam");
printdams("Klipdrift Dam");
printdams("Elandskuil Dam");
printdams("Rietspruit Dam");
printdams("Spitskop Dam");
printdams("Taung Dam");
printdams("Allemanskraal Dam");
printdams("Erfenis Dam");
printdams("Tierpoort Dam");
printdams("Kalkfontein Dam");
printdams("Rustfontein Dam");
printdams("Krugersdrift Dam");
printdams("Groothoek Dam");
printdams("Koppies Dam");
printdams("Sterkfontein Dam");
printdams("Saulspoort Dam");
printdams("Fika-Patso Dam");
printdams("Vaalharts Storage Weir");
printdams("Bloemhof Dam");
printdams("Douglas Storage Weir");
printdams("Sterkspruit Dam");
printdams("Katse Dam");
printdams("Mohale Dam");
printdams("Egmont Dam");
printdams("Armenia Dam");
printdams("Welbedacht Dam");
printdams("Knellpoort Dam");
printdams("Gariep Dam");
printdams("Vanderkloof Dam");
printdams("Disaneng Dam");
printdams("Setumo Dam");
printdams("Boegoeberg Dam");
printdams("Bulshoek Dam");
printdams("Clanwilliam Dam");
printdams("Karee Dam");
printdams("Voelvlei Dam");
printdams("Wemmershoek Dam");
printdams("Misverstand Dam");
printdams("Berg River Dam");
printdams("Steenbras Dam Lower");
printdams("Eikenhof Dam");
printdams("Steenbras Dam - Upper");
printdams("Debe Dam");
printdams("De Bos Dam");
printdams("Brandvlei Dam");
printdams("Stettynskloof Dam");
printdams("Ceres Dam");
printdams("Roode Els Berg Dam");
printdams("Lakenvallei Dam");
printdams("Poortjieskloof Dam");
printdams("Pietersfontein Dam");
printdams("Keerom Dam");
printdams("Klipberg Dam");
printdams("Kwaggaskloof Dam");
printdams("Theewaterskloof Dam");
printdams("Elandskloof Dam");
printdams("Buffeljags Dam");
printdams("Duiwenhoks Dam");
printdams("Korentepoort Dam");
printdams("Prinsrivier Dam");
printdams("Bellair Dam");
printdams("Floriskraal Dam");
printdams("Miertjieskraal Dam");
printdams("Calitzdorp Dam");
printdams("Leeugamka Dam");
printdams("Oukloof Dam");
printdams("Gamka Dam");
printdams("Gamkapoort Dam");
printdams("Kammanassie Dam");
printdams("Stompdrift Dam");
printdams("Hartebeestkuil Dam");
printdams("Klipheuwel Dam");
printdams("Ernest Robertson Dam");
printdams("Wolwedans Dam");
printdams("Garden Route Dam");
printdams("Roodefontein Dam");
printdams("Kromrivier Dam");
printdams("Impofu Dam");
printdams("Beervlei Dam");
printdams("Kouga Dam");
printdams("Haarlem Dam");
printdams("Loerie Dam");
printdams("Groendal Dam");
printdams("Nqweba (V. Rynevelds)");
printdams("Darlington Dam");
printdams("Grassridge Dam");
printdams("Kommandodrift Dam");
printdams("Elandsdrift Dam");
printdams("De Mistkraal Dam");
printdams("Glen Melville");
printdams("Katrivier Dam");
printdams("Sandile Dam");
printdams("Binfield Dam");
printdams("Laing Dam");
printdams("Rooikrantz Dam");
printdams("Bridle Drift Dam");
printdams("Nahoon Dam");
printdams("Macubeni Dam");
printdams("Xonxa Dam");
printdams("Lubisi Dam");
printdams("Doornrivier Dam");
printdams("Boesmanskrantz Dam");
printdams("Waterdown Dam");
printdams("Oxkraal Dam");
printdams("Ncora Dam");
printdams("Tsojana Dam");
printdams("Gubu Dam");
printdams("Wriggleswade Dam");
printdams("Gcuwa Dam");
printdams("Xilinxa Dam");
printdams("Toleni Dam");
printdams("Umtata");
printdams("Mabeleni Dam");
printdams("Corana Dam");
printdams("Belfort Dam");
printdams("Ntenetyana Dam");
printdams("Nqadu Dam");
printdams("Mlanga Dam");
printdams("Midmar Dam");
printdams("Nagle Dam");
printdams("Albert Falls Dam");
printdams("Inanda Dam");
printdams("Hazelmere Dam");
printdams("Spioenkop Dam");
printdams("Driel Barrage");
printdams("Woodstock Dam");
printdams("Craigie Burn Dam");
printdams("Mearns Dam");
printdams("Spring Grove Dam");
printdams("Ntshingwayo Dam");
printdams("Zaaihoek Dam");
printdams("Wagendrift Dam");
printdams("Goedertrouw Dam");
printdams("Klipfontein Dam");
printdams("Hluhluwe Dam");
printdams("Pongolapoort Dam");
printdams("Jericho Dam");
printdams("Westoe Dam");
printdams("Morgenstond Dam");
printdams("Heyshope Dam");
printdams("Nooitgedacht Dam");
printdams("Vygeboom Dam");
printdams("Driekoppies Dam");
printdams("Maguga Dam");
printdams("Longmere Dam");
printdams("Klipkopjes Dam");
printdams("Witklip Dam");
printdams("Primkop Dam");
printdams("Kwena Dam");
printdams("Da Gama Dam");
printdams("Inyaka Dam");


//System.out.println(data());

System.out.println("number of data:"+a);
System.out.println("---------------------------------------------------------------------");
}
}

public static void printdams(String query)
{
Dam d1 = new Dam(query,"","");
if(temp.find(d1) == null)
{
//System.out.println("Dam not found");
//num.add(temp.returnCount());
temp.resetc();
}
else
{
//System.out.println(makeBST().find(d1));
num.add(temp.returnCount());
System.out.println(temp.returnCount());
temp.resetc();
}
System.out.println("best:"+ getMin(num)+"worse:"+getMax(num)+ "avg:" +(getMin(num)/2 + getMax(num)/2));

}

public static int getMax(ArrayList<Integer> input)
{
int max = input.get(0);
for(int z =1;z<input.size();z++)
{
if(input.get(z)> max)
{
max = input.get(z);
}
}
return max;
}

public static int getMin(ArrayList<Integer> input)
{
int min = input.get(0);
for(int x=1;x<input.size();x++)
{
if(input.get(x)<min)
{
min = input.get(x);
}
}
return min;
}


}
