package qlymuonsach;

import java.util.Scanner;

public class qlMuonSach {
	static Scanner sc = new Scanner(System.in);
	private static banDoc[] arrBanDoc;
	private static sach[] arrSach;
	private static muonSach[] arrMuonSach;

	public void run() {
		int choose;
		do {
			System.out.println("mời bạn nhập chức năng:");
			System.out.println("1.Nhập danh sách đầu sách mới");
			System.out.println("2. nhập danh sách bạn học mới");
			System.out.println("3. quản lý mượn sách");
			System.out.println("4. săp xếp mượn sách theo tên");
			System.out.println("5.sắp xếp mượn sách theo số lượng mượn giảm");
			System.out.println("6. tìm kiếm theo tên ");
			System.out.println("0.thoát chương trình");
			choose = sc.nextInt();
			switch (choose) {
			case 1:
				AddSach();
				outputsach();
				break;
			case 2:
				AddBanDoc();
				outputbd();
				break;
			case 3:
				muonSach();
				break;
			case 4:
				sapxepten();
				break;
			case 5:
				break;
			case 6:
				timkiemten();
				break;

			default:
				break;
			}
		} while (choose > 0 && choose < 7);
	}

	public void AddBanDoc() {
		System.out.println("nhập số bạn đọc:");
		int a = sc.nextInt();
		arrBanDoc = new banDoc[a];
		for (int i = 0; i < a; i++) {
			System.out.println("bạn đọc thứ : " + (i + 1));
			banDoc banDoc = new banDoc();
			banDoc.addbandoc();
			arrBanDoc[i] = banDoc;
		}
	}

	public void outputbd() {
		for (banDoc banDoc : arrBanDoc) {
			System.out.println(
					banDoc.maBD + "\t\t" + banDoc.hoTen + "\t\t" + banDoc.diaChi + "\t\t" + banDoc.sDT + "\t\t" + banDoc.loaiBD);
		}
	}

	public void AddSach() {
		System.out.println("nhập số lượng sách:");
		int a = sc.nextInt();
		arrSach = new sach[a];
		for (int i = 0; i < a; i++) {
			System.out.println("thông tin sách : " + (i + 1));
			sach sach = new sach();
			sach.addsach();
			arrSach[i] = sach;
		}
	}

	public void outputsach() {
		for (sach sach : arrSach) {
			System.out.println(sach.maSach + "\t\t" + sach.tenSach + "\t\t" + sach.tacGia + "\t\t" + sach.chuyenNganh + "\t\t"
					+ sach.namXuatBan);
		}
	}

	public sach timkiemSach(int id) {
		for (sach sach : arrSach) {
			if (sach.getMaSach() == id) {
				return sach;
			}
		}
		return null;
	}


	public banDoc timkiembd(int idbd) {
		for (banDoc banDoc : arrBanDoc) {
			if (banDoc.getMaBD() == idbd)
				return banDoc;
		}
		return null;
	}


	public void muonSach() {
		int tong = 0;
		System.out.println("nhập số người mượn sách");
		boolean flag = false;
		int a;
		do {
			a = sc.nextInt();
			if (a > arrBanDoc.length) {
				System.out.println("nhập lại số người mượn sách:");
				flag = true;
			} else
				flag = false;
		} while (flag);

		arrMuonSach = new muonSach[a];
		for (int i = 0; i < a; i++) {
			System.out.println("nhập id người cần mượn cần mượn:");
			int idbd;
			banDoc banDoc;
			boolean kt = false;
			do {
				idbd = sc.nextInt();
				banDoc = timkiembd(idbd);
				if (banDoc == null) {
					System.out.println("nhập lại id:");
					kt = true;
				} else
					kt = false;
			} while (kt);

			System.out.println("nhập số đầu sách cần mượn:");
			int dauSach;
			do {
				dauSach = sc.nextInt();
				if (dauSach < 0 || dauSach > 5) {
					System.out.println("nhập số quyển sách cần mượn:");
					flag = true;
				} else
					flag = false;
			} while (flag);
			sach[] sachs = new sach[dauSach];
			int[] ListSL = new int[dauSach];
			for (int j = 0; j < dauSach; j++) {
				System.out.println("Nhập id sách cần mượn :");
				int id = sc.nextInt();
				sach sach = timkiemSach(id);
				int sls;
				System.out.println("nhập số lượng sách cần mượn:");
				do {
					sls = sc.nextInt();
					if (sls < 0 || sls > 3) {
						System.out.println("nhập lại số lượng:");
						flag = true;
					} else
						flag = false;
				} while (flag);
				ListSL[j] = sls;
				tong = tong + sls;
				sachs[j] = sach;
			}

			muonSach muonSach = new muonSach(sachs, banDoc, ListSL);
			arrMuonSach[i] = muonSach;
		}
	}

	public void output() {
		for (muonSach muonSach : arrMuonSach) {
			System.out.println(muonSach);
		}
	}

	public void sapxepten() {
		muonSach tam = new muonSach();
		for (int i = 0; i < arrMuonSach.length - 1; i++) {
			for (int j = i + 1; j < arrMuonSach.length; j++) {
				if (arrMuonSach[i].getBanDoc().getHoTen().compareTo(arrMuonSach[j].getBanDoc().getHoTen()) > 0) {
					tam = arrMuonSach[i];
					arrMuonSach[i] = arrMuonSach[j];
					arrMuonSach[j] = tam;
				}
			}
		}
		System.out.println("danh sách sau khi sắp xếp là :");
		for(int i = 0; i < arrMuonSach.length; i++) {
			System.out.println(arrMuonSach[i]);
		}
	}

	public void timkiemten(){
        Scanner sc=new Scanner(System.in);
        System.out.println("nhập tên tìm ki:");
        String ten=sc.nextLine();
        for(int i=0; i<arrMuonSach.length; i++){
            if(arrMuonSach[i].getBanDoc().getHoTen().equals(ten)==true)
                System.out.println(arrMuonSach[i]);
        }
    }
}
