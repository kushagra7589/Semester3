
lcd:     file format elf64-x86-64


Disassembly of section .text:

0000000000000000 <main>:

#include <stdio.h>
#include <stdlib.h> // For exit() function

int main()
{
   0:	55                   	push   %rbp
   1:	48 89 e5             	mov    %rsp,%rbp
   4:	48 81 ec 00 04 00 00 	sub    $0x400,%rsp
   b:	64 48 8b 04 25 28 00 	mov    %fs:0x28,%rax
  12:	00 00 
  14:	48 89 45 f8          	mov    %rax,-0x8(%rbp)
  18:	31 c0                	xor    %eax,%eax

    char s[1000];
	int c,i;
	i = 0;
  1a:	c7 85 00 fc ff ff 00 	movl   $0x0,-0x400(%rbp)
  21:	00 00 00 
    FILE *fptr;
	fptr = fopen("file1.txt", "r");
  24:	be 00 00 00 00       	mov    $0x0,%esi
  29:	bf 00 00 00 00       	mov    $0x0,%edi
  2e:	e8 00 00 00 00       	callq  33 <main+0x33>
  33:	48 89 85 08 fc ff ff 	mov    %rax,-0x3f8(%rbp)
    if(!fptr)
  3a:	48 83 bd 08 fc ff ff 	cmpq   $0x0,-0x3f8(%rbp)
  41:	00 
  42:	75 0a                	jne    4e <main+0x4e>
	return 0;
  44:	b8 00 00 00 00       	mov    $0x0,%eax
  49:	e9 cc 00 00 00       	jmpq   11a <main+0x11a>
	
	fscanf(fptr, "%[^\n]", s);
  4e:	48 8d 95 10 fc ff ff 	lea    -0x3f0(%rbp),%rdx
  55:	48 8b 85 08 fc ff ff 	mov    -0x3f8(%rbp),%rax
  5c:	be 00 00 00 00       	mov    $0x0,%esi
  61:	48 89 c7             	mov    %rax,%rdi
  64:	b8 00 00 00 00       	mov    $0x0,%eax
  69:	e8 00 00 00 00       	callq  6e <main+0x6e>
    	fclose(fptr);
  6e:	48 8b 85 08 fc ff ff 	mov    -0x3f8(%rbp),%rax
  75:	48 89 c7             	mov    %rax,%rdi
  78:	e8 00 00 00 00       	callq  7d <main+0x7d>

//   char c[100] = "abc";
 
// printf(s);
 int lcd;
    wiringPiSetup();
  7d:	e8 00 00 00 00       	callq  82 <main+0x82>
    lcd = lcdInit (2, 16, 4, LCD_RS, LCD_E, LCD_D4, LCD_D5, LCD_D6, LCD_D7, 0, 0, 0, 0);
  82:	48 83 ec 08          	sub    $0x8,%rsp
  86:	6a 00                	pushq  $0x0
  88:	6a 00                	pushq  $0x0
  8a:	6a 00                	pushq  $0x0
  8c:	6a 00                	pushq  $0x0
  8e:	6a 1d                	pushq  $0x1d
  90:	6a 15                	pushq  $0x15
  92:	6a 16                	pushq  $0x16
  94:	41 b9 17 00 00 00    	mov    $0x17,%r9d
  9a:	41 b8 18 00 00 00    	mov    $0x18,%r8d
  a0:	b9 19 00 00 00       	mov    $0x19,%ecx
  a5:	ba 04 00 00 00       	mov    $0x4,%edx
  aa:	be 10 00 00 00       	mov    $0x10,%esi
  af:	bf 02 00 00 00       	mov    $0x2,%edi
  b4:	e8 00 00 00 00       	callq  b9 <main+0xb9>
  b9:	48 83 c4 40          	add    $0x40,%rsp
  bd:	89 85 04 fc ff ff    	mov    %eax,-0x3fc(%rbp)
 lcdClear(lcd);  
  c3:	8b 85 04 fc ff ff    	mov    -0x3fc(%rbp),%eax
  c9:	89 c7                	mov    %eax,%edi
  cb:	e8 00 00 00 00       	callq  d0 <main+0xd0>
    lcdPuts(lcd, s);
  d0:	48 8d 95 10 fc ff ff 	lea    -0x3f0(%rbp),%rdx
  d7:	8b 85 04 fc ff ff    	mov    -0x3fc(%rbp),%eax
  dd:	48 89 d6             	mov    %rdx,%rsi
  e0:	89 c7                	mov    %eax,%edi
  e2:	e8 00 00 00 00       	callq  e7 <main+0xe7>
	sleep(3);
  e7:	bf 03 00 00 00       	mov    $0x3,%edi
  ec:	b8 00 00 00 00       	mov    $0x0,%eax
  f1:	e8 00 00 00 00       	callq  f6 <main+0xf6>
	lcdClear(lcd);
  f6:	8b 85 04 fc ff ff    	mov    -0x3fc(%rbp),%eax
  fc:	89 c7                	mov    %eax,%edi
  fe:	e8 00 00 00 00       	callq  103 <main+0x103>
	lcdPuts(lcd, "card read");
 103:	8b 85 04 fc ff ff    	mov    -0x3fc(%rbp),%eax
 109:	be 00 00 00 00       	mov    $0x0,%esi
 10e:	89 c7                	mov    %eax,%edi
 110:	e8 00 00 00 00       	callq  115 <main+0x115>
    return 0;
 115:	b8 00 00 00 00       	mov    $0x0,%eax
}
 11a:	48 8b 4d f8          	mov    -0x8(%rbp),%rcx
 11e:	64 48 33 0c 25 28 00 	xor    %fs:0x28,%rcx
 125:	00 00 
 127:	74 05                	je     12e <main+0x12e>
 129:	e8 00 00 00 00       	callq  12e <main+0x12e>
 12e:	c9                   	leaveq 
 12f:	c3                   	retq   
