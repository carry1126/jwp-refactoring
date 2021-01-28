# 키친포스

## 요구 사항
1.상품
* 상품을 생성한다.

  상품은이름과 가격으로 구성(**가격이 없거나 0이하이면 등록할 수 없음**)  
  

* 생성된 모든 상품을 조회한다.

2.메뉴
* 메뉴그룹 생성한다.(menu_group)
* 생성된 모든 메뉴그룹 조회한다.
* 메뉴를 생성한다.
  
  가격확인(**가격이 없거나 0이하이면 등록할 수 없음**)
  
  메뉴그룹확인(**메뉴그룹이 존재하지 않으면 등록할 수 없음**)
  

* 생성된 모든 메뉴를 조회한다.(*menu_product 연계*)

3.주문테이블(order_table)
* 주문테이블을 생성한다.(**단체지정(table_group_id null처리)**)
* 모든 주문테이블을 조회한다.
* 주문여부를 수정한다.(empty 주문등록여부 **table_group_id(null), OrderStatus(!COOKING, !MEAL) 수정가능**)
* 방문한 손님수를 수정한다.(**number_of_guests(empty(false)) 수정가능**)

4.주문(orders)
* 주문을 생성한다.(*order_line_item, order_table 연계, menueCount 비교, empty false*)
  
  **주문 항목이 없으면 등록할 수 없음**
  
  **주문 항목과 메뉴의 개수가 같지 않으면 등록할 수 없음**
  
  **주문 테이블이 없으면 등록할 수 없음**
  

* 생성된 모든 주문을 조회한다.(*order_line_item 연계*)
* 주문상태(order_status)를 수정한다.(*order_line_item 연계*)

  **주문이 없으면 수정할 수 없음**

  **주문상태(조리(COOKING) ➜ 식사(MEAL) ➜ 계산 완료(COMPLETION))가 계산 완료(COMPLETION)이면 수정할 수 없음**

  
5.단체지정(table_group)
* 단체지정을 생성한다.

  **주문테이블(*tableGroupId null*)이 2개 미만이면 등록할 수 없음**
  
  **등록된 주문테이블과 단체지정 주문테이블의 개수가 같지 않으면 등록할 수 없음**

  **주문테이블이 비워있지 않거나 단체지정이 되어 있으면 등록할 수 없음**


* 단제지정을 삭제한다.(*OrderTable tableGroupId null처리*)

  **주문상태가 조리, 식사일 경우 삭제할 수 없음**

## 용어 사전

| 한글명 | 영문명 | 설명 |
| --- | --- | --- |
| 상품 | product | 메뉴를 관리하는 기준이 되는 데이터 |
| 메뉴 그룹 | menu group | 메뉴 묶음, 분류 |
| 메뉴 | menu | 메뉴 그룹에 속하는 실제 주문 가능 단위 |
| 메뉴 상품 | menu product | 메뉴에 속하는 수량이 있는 상품 |
| 금액 | amount | 가격 * 수량 |
| 주문 테이블 | order table | 매장에서 주문이 발생하는 영역 |
| 빈 테이블 | empty table | 주문을 등록할 수 없는 주문 테이블 |
| 주문 | order | 매장에서 발생하는 주문 |
| 주문 상태 | order status | 주문은 조리 ➜ 식사 ➜ 계산 완료 순서로 진행된다. |
| 방문한 손님 수 | number of guests | 필수 사항은 아니며 주문은 0명으로 등록할 수 있다. |
| 단체 지정 | table group | 통합 계산을 위해 개별 주문 테이블을 그룹화하는 기능 |
| 주문 항목 | order line item | 주문에 속하는 수량이 있는 메뉴 |
| 매장 식사 | eat in | 포장하지 않고 매장에서 식사하는 것 |

## Step1
* 요구사항1 키친포스 요구사항 README.md에 작성
* 요구사항2 정리한 키친포스 요구 사항을 토대로 테스트 코드 작성(모든 Business Object)

## Step2
* INSIDE OUT 방식 구현(객체생활체조원칙 준수,setter 사용 x, 테스트하기 쉬운 부분과 어려운 부분(void) 분리) 
  
  **DOMAIN DOMAINTEST**
  
  **DTO**
  
* JPA적용
